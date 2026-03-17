-- Función del trigger
CREATE OR REPLACE FUNCTION fn_trg_check_min_stock()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    IF NEW.quantity < NEW.min_stock THEN
        RAISE WARNING
            'STOCK BAJO: El producto con inventory_id=% tiene % unidades (mínimo: %).',
            NEW.id,
            NEW.quantity,
            NEW.min_stock;
    END IF;

    RETURN NEW;
END;
$$;

-- Trigger asociado a la tabla inventory
CREATE OR REPLACE TRIGGER trg_check_min_stock
AFTER UPDATE OF quantity ON inventory
FOR EACH ROW
EXECUTE FUNCTION fn_trg_check_min_stock();