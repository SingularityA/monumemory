INSERT INTO monuments (name, description, history) VALUES
  ('Name_1', 'Description_1', 'History_1'),
  ('Name_2', 'Description_2', 'History_2'),
  ('Name_3', 'Description_3', 'History_3'),
  ('Name_4', 'Description_4', 'History_4');

INSERT INTO photo_sets (description, monument_id) VALUES
  ('Description_1', 1),
  ('Description_2', 1),
  ('Description_3', 2),
  ('Description_4', 2),
  ('Description_5', 3),
  ('Description_6', 3),
  ('Description_7', 4),
  ('Description_8', 4);

INSERT INTO photos (name, path, photo_set_id) VALUES
  ('Name_1', 'images/12345', 1),
  ('Name_2', 'images/23456', 1);