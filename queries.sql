-- Part 1: Test it with SQL
id (int)  name (varchar) employer_id (int);
-- Part 2: Test it with SQL
SELECT name
FROM employer
WHERE location = "St. Louis City";
-- Part 3: Test it with SQL
DROP TABLE job;
-- Part 4: Test it with SQL
--write a query to return a list of the names and descriptions of all skills that are attached
--to jobs in alphabetical order.
 --If a skill does not have a job listed, it should not be included in the results of this query.
SELECT *
FROM  skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id is not null
ORDER BY name ASC;


--spring.datasource.url=jdbc:mysql://localhost/techjobs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
