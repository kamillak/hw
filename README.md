<div align="center">
  <h3>Movies & Reeviews</h3>
  <h4>by Abzal Tashenov and Kuzbakova Kamilla <br> ST-2102 <br> Instructor: Nursultan Khaimuldin </h4>
</div>

# About the Project
Our project has 2 modes: moderator mode and user mode. 

User priviliges include: browsing through all movies, searching movies by their name, sorting movies by genre, country, name, actors, and year. Users can also leave reviews on movies, give their own rating, and calculcate average rating of the movie.

Moderator priviliges include: adding movies to the database, updating their information (cast, genre, country, etc), promoting certain users to the status of the moderator, or vice versa, demoting some moderators from their status. Moderators also can browse through every review that was left by users, and delete those, that violate certain terms of condition. 

# Responsibilities of each member
Kamilla was responsible with programming user's methods, and Abzal was responsible for moderator's features. 

# Class description
Overall, there are 9 classes (not taking into account interfaces): Mod & UserController, DB, Movie, User, Review, Mod & UserRepository, and Main.

Mod & UserRepository are responsible for various methods that are initialized in their respective interfaces. Meanwhile Mod & UserController helps us to output query result of those methods.

DB is used to connect to our PostgreSQL database and loading the driver into our program.

Entity classes (Movie, Review, User) are used to create objects of every table that our database has.
