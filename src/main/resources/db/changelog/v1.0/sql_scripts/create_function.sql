CREATE FUNCTION insert_into_student_progress()
RETURNS INT
    LANGUAGE plpgsql
AS $$
        BEGIN
            INSERT INTO student_progress(physic)
            VALUES (DEFAULT)
        END;
        $$;
\GO