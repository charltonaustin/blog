CREATE TABLE IF NOT EXISTS visits (
    route text,
    host text,
    user_agent text,
    origin text,
    remote_addr text,
    modtime   timestamp DEFAULT current_timestamp
);
