package model;

public class SiteEV {
  private int like; // よいねの数
  private int dislike; // よくないねの数

  public SiteEV() {
    like = 0;
    dislike = 0;
  }

  public int getLike() {
    return this.like;
  }

  public void setLike(int like) {
    this.like = like;
  }

  public int getDislike() {
    return this.dislike;
  }

  public void setDislike(int dislike) {
    this.dislike = dislike;
  }
}