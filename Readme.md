This is template project for android MDD framework extension
Follow the below tutorial to rename this template and create your own project 

Tutorial - Developing a mobile application named school for Schools.
---------

1. Create the project
   -Refactor root java source directory template -> school
   -Rename assets/template.sql -> assets/school.sql
   -Change rootProject.name in settings.gradle
   -change applicationId in build.gradle: template.app -> school.app
   -change name in .project file
   -change the app name in app.MainActivity   template -> school

   Build and veryfy your changes are working. If necessary revalidate cache in andrioid studio

2. Creating my first UI (Fragment)
   2.1. Copy the FragmentTemplateUI from app and create the fragment StudentRegUI  and copy the layout fragmenttemplate_ui and create the layout for StudentRegUI The layout file named as studentreg_ui
        please note the naming convention for class file and layout file of the UI
   2.2. Refactor the id other details in studentreg_ui: ItemRegUI->StudentRegUI, change MainActivity navigation to navigate to the this newly created fragment
   







1. How to create periodic action
1.1. create a action by extending the right baseAction
1.2. register the action in ActionRegister class
P.S. PeriodicActionsService must be registered in AndroidManifest as service


Limitations of periodic actions
1. PERIODIC_FOREGROUND action can be associated with only one view
2. All PERIODIC_FOREGROUND actions run when the app is visible however
optimally action should run only when the associated UI visible
3. Period between executions may vary in the order of milliseconds


Implementation Note
===================
Each periodic action is executed by a separate timer. It creates a separate thread for each action.
Alternatively, a single timer can be used.

According to periodic actions a device can be in 5 states
1. Device startup
2. App started by the icon after device startup
3. App went to background by pressing android home button
4. App closed by removing it from recent list
5. App started by the IDE run button (only happens at development time)


references
https://stackoverflow.com/questions/43674129/using-single-timer-vs-multiple-timers-for-scheduling-timertasks-in-android
https://stackoverflow.com/questions/46445265/android-8-0-java-lang-illegalstateexception-not-allowed-to-start-service-inten




Known Bugs
===========
1. Setting StrictMode.setVmPolicy  may find some unclosed resources in the android standard library