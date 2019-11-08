-- SQL: structured query language
-- CRUD operations: create, retrieve, update, delete

-- get all rows for artist. just the "name" column
select name
from artist;

-- get all rows for artist. just the "name" and "artistid" column
select artistid, name
from artist;

-- all columns
select * 
from invoice;

-- apply criteria (restrictions) filters
select * 
from invoice
where BillingCountry = 'Ireland';

-- multiple conditions
select * 
from invoice
where BillingCountry = 'Ireland' 
	OR BillingCountry = 'Germany';

select *
from invoice
where BillingCountry = 'Germany'
	AND BillingCity = 'Berlin';

-- INNER JOIN; only return rows where there are matches in the JP
select * 
from artist
inner join album
on album.artistid = artist.artistid; -- join predicate (JP)

select * from artist, album
where album.ArtistId = artist.ArtistId;

-- cartesian product
select * from artist, album;

-- OUTER JOIN; query from a table also the nulls (non-matches)
select * 
from playlisttrack p RIGHT JOIN track t
on p.TrackId = t.TrackId
where p.PlaylistId is null;
-- only tracks that are NOT on a playlist

select * 
from playlisttrack p LEFT JOIN track t
on p.TrackId = t.TrackId
where t.TrackId is null; -- empty playlist

select *
from playlisttrack p FULL OUTER JOIN track t
on p.TrackId = t.TrackId;

-- delete rows from a table
delete from playlisttrack where TrackId = 1;
-- delete from playlisttrack;  --will delete EveRytHINg
commit;

-- multiple joins
select Track.Name AS "Song", Artist.Name AS "Artist" 
from Track 
inner join album on track.AlbumId = album.AlbumId
inner join artist on album.ArtistId = artist.ArtistId;

-- WHERE clause
select * from track
where UnitPrice >= 0.99;

select * from track
where Milliseconds BETWEEN 2500000 AND 4500000;

-- finite set of values to search for
select * from track 
where GenreId IN (5, 10, 11);

-- SELF JOIN 
select E.FirstName, E.LastName, MANAGER.FirstName, MANAGER.LastName
from employee E LEFT join employee MANAGER
on E.ReportsTo = MANAGER.EmployeeId;

-- Scalar Function: function ran once for each and every row
select concat(E.FirstName, concat(' ', E.LastName)) AS 'Employee', 
	concat(MANAGER.FirstName, concat(' ', MANAGER.LastName)) AS 'Manager'
from employee E LEFT join employee MANAGER
on E.ReportsTo = MANAGER.EmployeeId;

-- Aggregate Function: use a list of rows as input and return a single result
select avg(unitprice) from track;
select min(unitprice) from track;
select max(unitprice) from track;
select count(trackid) from track;

-- number of Metallica songs
select count(distinct track.Name) from track 
inner join album a on a.AlbumId = track.AlbumId
inner join artist ar on ar.ArtistId = a.ArtistId
where ar.Name = 'Metallica';




