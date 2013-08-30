package org.mariotaku.twidere.fragment;

import java.io.File;

import org.mariotaku.twidere.loader.AbstractImageLoader.DownloadListener;
import org.mariotaku.twidere.loader.AbstractImageLoader.Result;
import org.mariotaku.twidere.loader.ImageLoader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public abstract class BaseImageViewerFragment extends BaseFragment implements LoaderCallbacks<ImageLoader.Result> {

	private File mImageFile;

	public File getImageFile() {
		return mImageFile;
	}

	@Override
	public final Loader<Result> onCreateLoader(final int id, final Bundle args) {
		final FragmentActivity activity = getActivity();
		return newLoaderInstance(activity, args, activity instanceof DownloadListener ? (DownloadListener) activity
				: null);
	}

	@Override
	public final void onLoaderReset(final Loader<Result> loader) {
		mImageFile = null;
	}

	@Override
	public void onLoadFinished(final Loader<Result> loader, final Result data) {
		mImageFile = data.file;

	}

	private Loader<Result> newLoaderInstance(final FragmentActivity activity, final Bundle args,
			final DownloadListener downloadListener) {
		return null;
	}
}