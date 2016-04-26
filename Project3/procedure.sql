-- change delimeter to $$
 DELIMITER $$
 CREATE PROCEDURE add_movie(m_title VARCHAR(100), m_year INT(11), dir VARCHAR(100), fn VARCHAR(50), lname VARCHAR(50), genre VARCHAR(32), OUT result VARCHAR(200))
 BEGIN
    DECLARE starID INT(11) DEFAULT NULL;
    DECLARE genreID INT(11) DEFAULT NULL;
    DECLARE movieID INT(11) DEFAULT NULL;

    SET starID = (SELECT id FROM stars WHERE first_name = fn AND last_name = lname);
    SET genreID = (SELECT id FROM genres WHERE name = genre);
    SET movieID = (SELECT id FROM movies WHERE title = title AND year = m_year AND director = dir);

    -- if movie does not exist, create it
    IF movieID IS NULL THEN
        INSERT INTO movies (title, year, director) VALUES(m_title, m_year, dir);
        SET movieID = (SELECT id FROM movies WHERE title = m_title AND year = m_year AND director = dir);
		 SET result = "Movie added Successfully!";
    END IF;
		
    -- if star exists, link it to movie
    -- else, create star then link it to movie
    IF starID IS NOT NULL THEN 
        INSERT INTO stars_in_movies VALUES(starID, movieID);
		/*SET result = "Stars in movies updated!";*/
	
    ELSE
        INSERT INTO stars (first_name, last_name) VALUES(fn, lname);
        SET starID = (SELECT id FROM stars WHERE first_name = fn AND last_name = lname);
        INSERT INTO stars_in_movies VALUES(starID, movieID);
		/*SET result = "Movie updated!";*/

    END IF;

    -- if genre exists, link it to movie
    -- else, create genre then link it to movie
    IF genreID IS NOT NULL THEN
        INSERT INTO genres_in_movies VALUES(genreID, movieID);
		/* SET result = "Genres in movies updated"; */
	
    ELSE
        INSERT INTO genres (name) VALUES(genre);
        SET genreID = (SELECT id FROM genres WHERE name = genre);
        INSERT INTO genres_in_movies VALUES(genreID, movieID);
		/*SET result = "Movie Updated!";*/
    END IF;

END
//

-- change delimiter to ;
DELIMITER ;