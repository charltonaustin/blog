-- :name create-title_tag! :! :n
-- :doc creates a new user record
INSERT INTO title_tag
(title)
VALUES (:text)

-- :name update-title_tag! :! :n
-- :doc update an existing user record
UPDATE title_tag
SET title = :text
WHERE id = :id

-- :name get-title_tag :? :1
-- :doc retrieve a user given the id.
SELECT * FROM title_tag
WHERE id = :id

-- :name delete-title_tag! :! :n
-- :doc delete a user given the id
DELETE FROM title_tag
WHERE id = :id
