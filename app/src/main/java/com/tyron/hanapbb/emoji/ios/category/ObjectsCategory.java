package com.tyron.hanapbb.emoji.ios.category;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.tyron.hanapbb.R;
import com.tyron.hanapbb.emoji.EmojiCategory;
import com.tyron.hanapbb.emoji.ios.IosEmoji;

@SuppressWarnings("PMD.MethodReturnsInternalArray") public final class ObjectsCategory implements EmojiCategory {
    private static final IosEmoji[] EMOJIS = CategoryUtils.concatAll(ObjectsCategoryChunk0.get());

    @Override @NonNull
    public IosEmoji[] getEmojis() {
        return EMOJIS;
    }

    @Override @DrawableRes
    public int getIcon() {
        return R.drawable.emoji_ios_category_objects;
    }

    @Override @StringRes
    public int getCategoryName() {
        return R.string.emoji_ios_category_objects;
    }
}