SELECT 
	la.idloan_appeal, 
	concat(client_personal_data.last_name, ' ', client_personal_data.first_name, ' ', client_personal_data.middle_name) AS FIO, 
	la.appeal_date,
    la.loan_amount,
    la.credit_term,
    la.loan_rate,
    la.status 
FROM  loan_appeal as la
INNER JOIN client_personal_data ON la.client_inn = client_personal_data.client_inn 
WHERE partner_inn=2000000005