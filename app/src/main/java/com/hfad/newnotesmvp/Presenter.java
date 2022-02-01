package com.hfad.newnotesmvp;

public class Presenter implements IContract.IPresenter{
    public Presenter(IContract.IView myMVPView) {
        this.myMVPView = myMVPView;
        this.myMVPModel = new Model();
    }

    IContract.IView myMVPView;
    IContract.IModel myMVPModel;
    @Override
    public void openNote() {

    }
}
