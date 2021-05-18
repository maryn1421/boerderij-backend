<h3 align="center">De Boerderij</h3>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li>
        <a href="#local">Local</a>
            <ul>
                <li><a href="#prerequisites">Prerequisites</a></li>
                <li><a href="#installation">Installation</a></li>
            </ul>
        </li>
        <li>
        <a href="#Cloud">Cloud</a>
            <ul>
                <li><a href="#prerequisites">Prerequisites</a></li>
                <li><a href="#Deploy">Deploy</a></li>
            </ul>
            </li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

Its a basic app for farmers  to track the incomes, costs and orders.
A "jófogás" copy is currently under development (the piac section).


<b>To visit the project: <a href="https://boerderij.hu" />Boerderij.hu </a> </b>

If you dont want to register a new account you can use a test account:
email: test@test.com
password: test123

### Built With

This section should list any major frameworks that you built your project using. Leave any
add-ons/plugins for the acknowledgements section. Here are a few examples.

* Spring Boot
* React
* Java
* Hibernate
* JWT
* OAuth2 (not used, but implemented)

<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a
local copy up and running follow these simple example steps.

### Local

#### Prerequisites

* maven
  ```sh
  sudo apt-get install maven
  ```
* postgresql
  ```sh
  sudo apt-get -y install postgresql
  ```

#### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/maryn1421/boerderij-backend.git
   ```
2. set environment variables
   * DATABASE_NAME -> name of your postgres database
   * DATABASE_URL -> url if your postgres db (JDBC)
   * PASSWORD -> password for postgresql user
   * USERNAME -> postgresql username

3. Change the API_BASE_URL varaible in the front end project. 
   
### Cloud

#### Prerequisites

* heroku
  Register at [https://www.heroku.com/](https://www.heroku.com/)

#### Deploy

1. Create application on Heroku
2. Create Config Vars on "Settings" tab
3. Connect heroku to github repository
4. Select a branch to deploy. Currently "development" is created for this purpose.

