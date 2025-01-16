-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME from ANIMAL_INS
where NAME like "%el%"
and ANIMAL_TYPE = "dog"
order by NAME