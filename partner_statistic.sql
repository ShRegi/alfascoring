SELECT 
	partners.company_name,
    COUNT(la.idloan_appeal) AS Appeals_summ,
    SUM(case when la.status = 'approved' then 1 else 0 end ) AS Approved,
    SUM(case when la.status like'rejec%' then 1 else 0 end ) AS Rejected,
	SUM(loan_amount) AS Sum_of_loans
FROM loan_appeal as la
INNER JOIN partners ON partners.partner_inn = la.partner_inn
group by la.partner_inn
order by la.partner_inn