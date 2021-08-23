USE GothicLlamasDB;

CREATE TABLE IF NOT EXISTS capabilityAndRoles (
    capability ENUM('Engineering', 'Platforms', 'Data', 'Artificial Intelligence', 'Cyber Security',
    'Product', 'Delivery', 'Operations', 'Business Development and Marketing', 'Organisational Strategy and Planning',
    'People', 'Commercial and Financial Management', 'Business Services Support'),
    bandLevel ENUM ('7 - apprentice', '6 - trainee',  '5 - associate', '4 - senior associate',
    '3 - consultant', '2 - manager', '1 - principal '),
    jobRole VARCHAR(50),
    jobDescription VARCHAR(500),
    linkToFullDescription VARCHAR (200)
);