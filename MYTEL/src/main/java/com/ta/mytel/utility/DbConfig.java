package com.ta.mytel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DbConfig {
	
	private static Properties properties;
	private static final String CONFIG_FILE_PATH = "D:\\MYTEL\\config\\config.properties";
	private static final File configFile = new File(CONFIG_FILE_PATH);
	private static final Logger log = LogManager.getLogger();

	static {
		try {
			loadProperties();
			startFileWatcher(Paths.get(configFile.getParent()));
		} catch (IOException e) {
			log.error(e);
		}
	}

	private DbConfig() {
	}

	public static Properties getProperties() {
		return properties;
	}

	private static void loadProperties() {
		try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
			properties = new Properties();
			properties.load(input);
			log.info("Configuration loaded.");
		} catch (IOException e) {
			log.error("Unable to find or load the configuration file", e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	private static void startFileWatcher(Path dir) throws IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

		new Thread(() -> {
			while (true) {
				try {
					WatchKey key = watchService.take();
					for (WatchEvent<?> event : key.pollEvents()) {
						WatchEvent.Kind<?> kind = event.kind();

						if (kind == StandardWatchEventKinds.OVERFLOW) {
							continue;
						}

						WatchEvent<Path> ev = (WatchEvent<Path>) event;
						Path changedFile = ev.context();

						if (changedFile.endsWith(configFile.getName())) {
							log.info("Configuration file modified. Reloading...");
							loadProperties();
						}
					}
					key.reset();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}).start();
	}
}
