package com.powerise.demoapp.splash.models

/**
 * Created by Krunal on 08-06-2018.
 */
data class Response(
        val id: String,
        val created_at: String,
        val release_date: String,
        val release_timestamp: Int,
        val user_id: String,
        val duration: String,
        val permalink: String,
        val description: String,
        val geo: String,
        val tags: String,
        val taged_artists: String,
        val bpm: String,
        val key: String,
        val license: String,
        val version: String,
        val type: String,
        val downloadable: Int,
        val genre: String,
        val genre_slush: String,
        val title: String,
        val uri: String,
        val permalink_url: String,
        val thumb: String,
        val artwork_url: String,
        val artwork_url_retina: String,
        val background_url: String,
        val waveform_data: String,
        val waveform_url: String,
        val user: User,
        val stream_url: String,
        val preview_url: String,
        val download_url: String,
        val playback_count: String,
        val download_count: String,
        val favoritings_count: String,
        val reshares_count: String,
        val comment_count: String,
        val played: Boolean,
        val favorited: Boolean,
        val reshared: Boolean
)

data class User(
        val id: String,
        val permalink: String,
        val username: String,
        val uri: String,
        val permalink_url: String,
        val avatar_url: String
)
