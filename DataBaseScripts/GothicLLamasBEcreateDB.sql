USE GothicLlamasDB;

CREATE TABLE IF NOT EXISTS capabilityAndRoles (
    capability ENUM('Engineering', 'Platforms', 'Data', 'Artificial Intelligence', 'Cyber Security',
    'Product', 'Delivery', 'Operations', 'Business Development and Marketing', 'Organisational Strategy and Planning',
    'People', 'Commercial and Financial Management', 'Business Services Support'),
    bandLevel ENUM ('7 - apprentice', '6 - trainee',  '5 - associate', '4 - senior associate',
    '3 - consultant', '2 - manager', '1 - principal '),
    jobRole VARCHAR(50) NOT NULL,
    jobDescription VARCHAR(500) NOT NULL,
    linkToFullDescription VARCHAR (200) NOT NULL
<<<<<<< HEAD
);
=======
);
>>>>>>> 65bad3efddba3e66425417f1f3d16057eb0b270b
