CREATE OR REPLACE FUNCTION count_type_document()
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    total INTEGER;
BEGIN
    SELECT COUNT(*) INTO total FROM type_document;
    RETURN total;
END;
$$;