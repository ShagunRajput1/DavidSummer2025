## How to add Pedro Pathing to a library

1. make sure you have mecanum drive
2. add these to build dependencies gradle repo:
      maven { url = 'https://maven.brott.dev/' }
      maven { url= 'https://maven.pedropathing.com/' }
3. add these to build dependencies gradle dependencies:
      implementation 'com.pedropathing:pedro:[VERSION]' (check website for version)
      implementation 'com.acmerobotics.dashboard:dashboard:0.4.16'
4. make a pedroPathing package and import all the team code files from the github repo to your repo: https://github.com/Pedro-Pathing/Quickstart
5. FConstants:

      FollowerConstants.localizers = Localizers.[NAME OF LOCALIZER]};

         // add the names of the motors

           FollowerConstants.leftFrontMotorName = "";
           FollowerConstants.leftRearMotorName = "";
           FollowerConstants.rightFrontMotorName = "";
           FollowerConstants.rightRearMotorName = "";

         // check directionality

           FollowerConstants.leftFrontMotorDirection = DcMotorSimple.Direction.REVERSE;
           FollowerConstants.leftRearMotorDirection = DcMotorSimple.Direction.REVERSE;
           FollowerConstants.rightFrontMotorDirection = DcMotorSimple.Direction.FORWARD;
           FollowerConstants.rightRearMotorDirection = DcMotorSimple.Direction.FORWARD;

         // add robot weight in kg

           FollowerConstants.mass = 11.6;
6. LConstants:
      
      specific to what localizer you are using. there are different pages for each localizer in: https://pedropathing.com/pedro/localization/pick.html
7. run localizer file and see how everything works out