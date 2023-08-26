-- Insertion of mock user
INSERT INTO "user" ("name", "email","password")
VALUES
    ('John Doe', 'john@example.com', 'password123'),
    ('Jane Smith', 'jane@example.com', 'securepass'),
    ('Alice Johnson', 'alice@example.com', 'p@ssw0rd'),
    ('Bob Anderson', 'bob@example.com', '12345'),
    ('Eva Williams', 'eva@example.com', 'qwerty'),
    ('Michael Brown', 'michael@example.com', 'mypass123'),
    ('Sophia Davis', 'sophia@example.com', 'secretpassword'),
    ('William Miller', 'william@example.com', 'password123');
-- --------------------------------------------------------------------
-- Insertion of mock tag
INSERT INTO "tag" ("name")
VALUES
    ('Important'),
    ('In Progress'),
    ('Completed'),
    ('To Review'),
    ('Postponed'),
    ('Urgent'),
    ('Scheduled'),
    ('Draft'),
    ('Blocked'),
    ('Cancelled');
-- --------------------------------------------------------------------
-- Insertion of mock projects
INSERT INTO "project" ("name", "description", "status", "startdate", "enddate", "userid")
VALUES
    ('Website Redesign', 'Redesigning company website for better user experience.', true, '2023-07-15 09:00:00', '2023-09-30 18:00:00', 1),
    ('Product Launch', 'Preparing for the launch of a new product into the market.', false, '2023-08-10 10:00:00', '2023-10-15 15:00:00', 2),
    ('Marketing Campaign', 'Planning and executing a social media marketing campaign.', true, '2023-07-20 08:00:00', '2023-09-10 17:00:00', 3),
    ('Client Onboarding', 'Onboarding new clients and setting up their accounts.', true, '2023-08-01 09:30:00', '2023-09-25 16:30:00', 1),
    ('Research Project', 'Conducting research on industry trends and customer preferences.', false, '2023-08-15 11:00:00', '2023-10-05 14:00:00', 4),
    ('Event Planning', 'Organizing a company-wide annual event for employees.', true, '2023-09-05 10:00:00', '2023-11-10 17:00:00', 2),
    ('Inventory Management', 'Optimizing inventory management system for cost efficiency.', true, '2023-08-10 09:30:00', '2023-09-30 16:00:00', 5),
    ('Training Program', 'Developing a training program for new hires and employees.', false, '2023-09-01 08:00:00', '2023-10-20 17:00:00', 3),
    ('Product Updates', 'Rolling out updates and patches for existing software products.', true, '2023-08-20 10:30:00', '2023-09-25 15:30:00', 4),
    ('Budget Review', 'Reviewing and adjusting financial budgets for the next quarter.', false, '2023-09-10 11:30:00', '2023-10-15 14:30:00', 1);
-- --------------------------------------------------------------------
-- Insertion of mock task
INSERT INTO "task" ("title", "status", "startdate", "enddate", "priority", "userid", "projectid", "tagid")
VALUES
    ('Design Homepage', false, '2023-08-02 10:00:00', '2023-08-10 18:00:00', 2, 1, 1, 2),
    ('Write Product Description', true, '2023-08-05 11:00:00', '2023-08-08 15:00:00', 1, 2, 2, 1),
    ('Create Social Media Graphics', false, '2023-08-03 09:00:00', '2023-08-09 17:00:00', 3, 3, 1, 3),
    ('Client Meeting Preparation', true, '2023-08-04 13:00:00', '2023-08-04 15:00:00', 1, 1, 3, 5),
    ('Data Analysis', false, '2023-08-06 14:00:00', '2023-08-15 18:00:00', 2, 4, 2, 4),
    ('Finalize Event Schedule', true, '2023-08-07 12:00:00', '2023-08-10 16:00:00', 1, 2, 4, 7),
    ('Update Inventory Records', false, '2023-08-08 09:30:00', '2023-08-12 14:00:00', 2, 5, 3, 6),
    ('Training Content Creation', true, '2023-08-09 11:30:00', '2023-08-14 15:30:00', 1, 3, 5, 8),
    ('Bug Fixing', false, '2023-08-10 10:00:00', '2023-08-18 17:00:00', 2, 4, 2, 9),
    ('Budget Analysis', true, '2023-08-11 13:00:00', '2023-08-13 15:00:00', 1, 1, 6, 10);
-- --------------------------------------------------------------------
-- Insertion into "include" table
INSERT INTO "include" ("userid", "projectid")
VALUES
    (1, 1),
    (2, 2),
    (3, 1),
    (4, 3),
    (1, 2),
    (2, 1),
    (5, 4),
    (3, 3),
    (4, 2),
    (1, 5);