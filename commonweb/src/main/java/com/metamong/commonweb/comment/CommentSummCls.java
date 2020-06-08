package com.metamong.commonweb.comment;

public class CommentSummCls {
    private String comment;
    private int up;
    private int down;

    public CommentSummCls(String comment, int up, int down) {
        this.comment = comment;
        this.up = up;
        this.down = down;
    }

    public String getComment() {
        return comment;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public String getVotes() {
        return getUp() + " " + getDown();
    }
}
