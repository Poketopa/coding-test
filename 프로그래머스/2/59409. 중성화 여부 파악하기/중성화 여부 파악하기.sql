-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, 
case when SEX_UPON_INTAKE like "%Neutered%" or 
    SEX_UPON_INTAKE LIKE "%Spayed%" then "O"
    else "X" end FROM ANIMAL_INS
order by ANIMAL_ID