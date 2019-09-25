
# VotePam

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Votepam is an app that lets people vote online, allows one person to vote once and then reduces fraud.

### App Evaluation
- **Category:** web portail 
- **Mobile:** This application would be developed for mobile, web but could be just as viable on a computer.
The feature would not be limited to mobile devices, but the mobile version could potentially have more
features.
- **Story:** Votepam is an app that lets you vote online, it facilitates you to vote either on your Android phone or on the go without moving your house.
- **Market:** Anyone wishing to vote during elections at this time can use this app.
- **Habit:** This app should be used during the election.
- **Scope:** This app will allow voters to have a clear confidence that those in the polls are really good at preventing people from doubting their results.
## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] User can login with id and firstname
- [x] Used will be able to select a candidate he wants to vote
- [x] Users will be able to see all the information about it when logged in
- [ ] Users will be able to see all the candidates it has voted for
- [ ] Used can vote for the candidate he wants

**Optional Nice-to-have Stories**

- [ ] Users can search each candidate either president, senator or Member of Parliament
- [ ] User can log out

### 2. Screen Archetypes

* Login
   * User can login with id and firstname
* Profile Screen 
   * Users can view all information about it when logged in
* Candidate Selection Screen
   * Users can see their candidates by category
   * Users can select candidates by voting category
* Detail Screen
   * Users can view the political part and number of each candidate
   * Users can see all the candidates they voted for

### 3. Navigation User

**Flow Navigation** (Screen to Screen)
* Login
   * Login Screen
   * User information Screen
* Candidate Screen
   * Candidate category screen
   * Screen listing of candidates by category
   * Candidate detail screen
   * Screen List of candidates you vote for

## Wireframes
<img src="https://github.com/Dumonvil/VotePam/blob/master/wireframe.jpg" width=800><br>

### [BONUS] Digital Wireframes & Mockups
<span> <img src="https://imgur.com/ilMaSTH.png" width=100>
<img src="https://imgur.com/qZvpYA4.png" width=100>
<img src="https://imgur.com/KtbDhEI.png" width=100>
<img src="https://imgur.com/Ls25NxQ.png" width=100>
<img src="https://imgur.com/15o3HGG.png" width=100>
<img src="https://imgur.com/ONnY0NP.png" width=100>
<img src="https://imgur.com/93Lrz8W.png" width=100>
<img src ="https://imgur.com/dVv2Rzt.png" width=100>
<img src="https://imgur.com/aXAYwe9.png" width=100>
<img src="https://imgur.com/rUAz0n6.png" width=100>
<img src="https://imgur.com/aE8u6NF.png" width=100>
<img src="https://imgur.com/lFRrlVX.png" width=100>
</span>

### [BONUS] Interactive Prototype
https://www.figma.com/file/lQhrESAOY3fIJCpWWGeDZP/Untitled?node-id=63%3A7
<br>
<br>
<img src="https://github.com/Dumonvil/VotePam/blob/master/projetcodepath.gif" width=200>

## Schema 

### Models

Model: User

| Property  | Type     | Description                           |
| --------  | -------- | ----------------------------------    |
| Name      | String   | Name of the User           	       |
| FirstName  | String   | Firstname of the User		       |
| ObjectID   | String   | Unique id for User		       |
| Adress   | String   | Adress of the User		       |
| ProfileImage| File     | Profile of the User                 |
| CreatedAt | Datetime | Date created user (default field)     |
| UpdateAt  | Datetime | Date last updated user (default field)|
| Birthplace | String  | The place where the User was born                 |
| Birth Date| String | The date that the User was born        |


Model: President

| Property  | Type     | Description                           |
| --------  | -------- | -----------------------------------   |
| ObjectId  | String   | User uses a unique identifier to login|           	       |
| Name      | String   | Name of the president		       |
| Firstname | String   | Firstname of the president	       |
| CreatedAt | Datetime | Date created user (default field)     |
| UpdateAt  | Datetime | Date last updated user (default field)|
| ProfileImage| File     | Profile of the user                   |
| Politic part |String    | Common political ideas united in association              |
| Candidate Number  | Number |Number of president	       |
| Birthplace | String  | The place where the President was born                   |
| Birth Date | String | The date that the President was born        |
| Mission   | String   | Mission of the President		       |
 

Model: Senator

| Property  | Type     | Description                           |
| --------  | -------- | --------------------------------------|
| ObjectId  | String   | User uses a unique identifier to login|           	       |
| Name      | String   | Name of Senator	       |
| Firstname | String   | Firstname of Senator	       |
| ProfileImage| File     | Profile of the Senator                   |
| Politic part|String    | Common political ideas united in association              |
| Birthplace | String  | The place where the Senator was born                   |
| CreatedAt | Datetime | Date created Senator (default field)     |
| UpdateAt  | Datetime | Date last updated Senator (default field)|
| Birth Date | String | The date that the Senator was born        |
| Candidate Number | Number |Number of Senator	       |
| Mission   | String   | Mission of the Senator		       |

Model: Member of parliament

| Property  | Type     | Description                           |
| --------  | -------- | --------------------------------------|
| ObjectId  | String   | User uses a unique identifier to login|           	       |
| Name      | String   | Name of member of parliament       |
| Firstname | String   | Firstname of member of parliament	       |
| ProfileImage| File   | Profile of the member of parliament                   |
| CreatedAt | Datetime | Date created member of parliament (default field)     |
| UpdateAt  | Datetime | Date last updated member of parliament (default field)|
| Birthplace | String  | The place where the member of parliament was born                |
| Birth Date | String | The date that the member of parliament was born        |
| Politic part |String    | Common political ideas united in association               |
| Candidate Number | Number |Politic's number of member of parliament	       |
| Mission   | String   | Mission of the member of parliament	       |


### Networking

* Login Screen
   * (Read / GET) Query to connect with user id.

* Candidate selection screen
   * (Read / GET) Query to display names and photos of candidates by categories.

* Profil Screen
   * (Read/ GET) Query to display all the information about the user. His picture, his name and surname, his date of birth and his birthplace.

* Detail
   * (Read / GET) Query to view the details of each candidate select before voting.
* Post-detail
   * (Read / GET) Query to display all the candidates chosen by the user.




 

