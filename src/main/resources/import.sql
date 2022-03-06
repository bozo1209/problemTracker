insert into market_group values(1, 'hub kat')
insert into market_group values(2, 'hub buh')
insert into market_group values(3, 'hub ede')

insert into market values(1, 'pl', 1)
insert into market values(2, 'uk', 1)
insert into market values(3, 'fr', 1)
insert into market values(4, 'ro', 2)
insert into market values(5, 'br', 3)

--password = pass
insert into users values(1, 'one', '$2a$10$.UO2SqcArkRv6DfH4P5xyelNVa5uY4mMf9A0qEcZoixDDnbdn9VJW', 'LEADER_POSTER')
insert into users values(2, 'two', '$2a$10$.UO2SqcArkRv6DfH4P5xyelNVa5uY4mMf9A0qEcZoixDDnbdn9VJW', 'POSTER')
insert into users values(3, 'three', '$2a$10$.UO2SqcArkRv6DfH4P5xyelNVa5uY4mMf9A0qEcZoixDDnbdn9VJW', 'LEADER_RECEIVER')
insert into users values(4, 'four', '$2a$10$.UO2SqcArkRv6DfH4P5xyelNVa5uY4mMf9A0qEcZoixDDnbdn9VJW', 'RECEIVER')

--insert into note values(1, '2021-12-21', 'issue', 'aa11', 'open', 1, 1)
--insert into note values(2, '2021-12-21', 'issue', 'aa11', 'open', 2, 2)
--insert into note values(3, '2021-12-21', 'issue', 'aa11', 'open', 4, 1)
--insert into note values(4, '2021-12-21', 'issue', 'aa12', 'open', 5, 3)
--insert into note values(5, '2021-12-21', 'issue', 'aa12', 'open', 1, 1)
--insert into note values(6, '2021-12-21', 'issue', 'aa11', 'open', 2, 2)
--insert into note values(7, '2021-12-21', 'issue', 'aa12', 'open', 4, 1)
--insert into note values(8, '2021-12-21', 'issue', 'aa11', 'open', 5, 3)
--insert into note values(9, '2021-12-21', 'issue', 'aa13', 'open', 1, 1)
--insert into note values(10, '2021-12-21', 'issue', 'aa11', 'open', 2, 2)
--insert into note values(11, '2021-12-21', 'issue', 'aa13', 'open', 4, 1)
--insert into note values(12, '2021-12-21', 'issue', 'aa11', 'open', 5, 3)


--select n.id, n.data, n.description, n.outside_number, n.status, mg.name hub_name, u.name user_name from note n inner join market m on m.id = n.market_id inner join market_group mg on mg.id = m.market_group_id inner join users u on n.users_id = u.id
