USE GothicLlamasDB;

--US001 -> View job roles within Kainos

SELECT jobRole AS "Job role in Kainos" FROM capabilityAndRoles;

--US002 -> View job description and view and follow link to job description on sharepoint

SELECT jobDescription AS "Job description", linkToFullDescription AS "Link to SharePoint" FROM capabilityAndRoles;

--US003 -> View capability that each job role falls within

SELECT jobRole AS "Job role in Kainos", capability AS "Capability" FROM capabilityAndRoles;