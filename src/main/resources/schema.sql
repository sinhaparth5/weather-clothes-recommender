CREATE TABLE IF NOT EXISTS weather_data (
                                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                                            location TEXT,
                                            date DATE,
                                            temp REAL,
                                            weather_description TEXT
);
