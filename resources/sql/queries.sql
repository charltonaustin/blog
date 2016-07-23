-- :name create-visit! :! :n
-- :doc creates a new user record
INSERT INTO visits
(route, host, user_agent, origin, remote_addr)
VALUES (:route, :host, :user_agent, :origin, :remote_addr)
