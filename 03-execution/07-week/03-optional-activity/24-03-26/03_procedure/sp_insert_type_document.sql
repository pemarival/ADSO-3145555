CREATE OR REPLACE PROCEDURE insert_type_document(
    p_name VARCHAR,
    p_abbreviation VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO type_document(name, abbreviation)
    VALUES (p_name, p_abbreviation);
END;
$$;