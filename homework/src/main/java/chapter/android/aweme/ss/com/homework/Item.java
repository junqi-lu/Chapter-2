package chapter.android.aweme.ss.com.homework;

public class Item {

    private int mAvatarId;
    private int mRobotNoticeId;
    private String mDescription;
    private String mTitle;
    private String mTime;

    public Item(int avatarId, int robotNoticeId, String description, String title, String time) {
        mAvatarId = avatarId;
        mRobotNoticeId = robotNoticeId;
        mDescription = description;
        mTitle = title;
        mTime = time;
    }

    public int getAvatarId() {
        return mAvatarId;
    }

    public int getRobotNoticeId() {
        return mRobotNoticeId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getTime() {
        return mTime;
    }

}
