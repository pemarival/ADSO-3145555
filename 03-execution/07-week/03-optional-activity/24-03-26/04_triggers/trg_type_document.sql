CREATE OR REPLACE FUNCTION log_type_document()
RETURNS trigger
LANGUAGE plpgsql
AS $$
BEGIN
    RAISE NOTICE 'Nuevo tipo de documento insertado: %', NEW.name;
    RETURN NEW;
END;
$$;

CREATE TRIGGER trg_type_document
AFTER INSERT ON type_document
FOR EACH ROW
EXECUTE FUNCTION log_type_document();