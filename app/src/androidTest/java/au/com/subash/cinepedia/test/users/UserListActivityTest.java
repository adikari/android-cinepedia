package au.com.subash.cinepedia.test.users;
/*
import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import au.com.subash.cinepedia.users.UserListActivity;
import au.com.subash.cinepedia.R;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserListActivityTest extends ActivityInstrumentationTestCase2<UserListActivity> {

  private UserListActivity userListActivity;

  public UserListActivityTest() {
    super(UserListActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    userListActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsUserListFragment() {
    Fragment userListFragment =
        userListActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
    assertThat(userListFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.userListActivity.getTitle().toString().trim();

    assertThat(actualTitle, is("Users List"));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        UserListActivity.getCallingIntent(getInstrumentation().getTargetContext());

    return intentLaunchActivity;
  }
}*/
