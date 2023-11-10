\GO
CREATE TRIGGER add_default_raw_at_student_progress
    BEFORE INSERT
    ON student
EXECUTE FUNCTION insert_into_student_progress();