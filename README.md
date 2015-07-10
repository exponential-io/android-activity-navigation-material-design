# Android Navigation via NavigationView

Learn how to use the Material Design Support Library's NavigationView to navigate between multiple fragments.

## Copy repo

Create new **empty** repo on GitHub

Run the following commands to base the new repo on the existing `android-navigationview-material-design` repo.

```bash
cd ~/repos/android

git clone git@github.com:exponential-io/android-navigationview-material-design.git android-navigation-material-design

cd android-navigation-material-design

# Change the git@github URL below to match your repo
git remote set-url origin git@github.com:exponential-io/android-navigation-material-design.git

git push origin master

# View remote urls
git remote -v
```

## Rename project in Android Studio

- Open the new project in Android Studio.
- Right-click on **app** in the Project pane, click **Open Module Settings**.
- In the **Project Structure** dialog box, click the **Flavors** tab.
    - Change the **Application Id** to `mdnavigation`.
    - Click **OK**.
- Open `build.gradle`:
    - Notice how `applicationId` has been changed to `mdnavigation`.
- Open the `AndroidManifest.xml`:
    - Change the package to `mdnavigation`.
- Refactor the `io.exponential.mdnavigationview` package to `io.exponential.mdnavigation`.
- Open `MainActivity.java:
    - Change the package to `package io.exponential.mdnavigation;`.
- Open `MainFragment.java:
    - Change the package to `package io.exponential.mdnavigation;`.
- Open `strings.xml`:
    - Change `app_name` to `Material Design Navigation`.
- Select **Build**, click **Clean**.
- Select **Build**, click **Rebuild Project**.
- Commit your changes to git.
- Select **File**, click **Invalidate Caches / Restart...**.

## Follow commit log

You can now start to follow the steps to implement navigation via the NavigationDrawer through the git commit log. Begin with the commits that are prefixed with `nav:`.
