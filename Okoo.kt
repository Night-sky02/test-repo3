package fr.okoo

import eu.kanade.tachiyomi.animesource.online.WebViewAnimeHttpSource
import okhttp3.Request
import eu.kanade.tachiyomi.animesource.model.AnimeFilterList
import eu.kanade.tachiyomi.animesource.model.SAnime
import eu.kanade.tachiyomi.animesource.model.SEpisode
import eu.kanade.tachiyomi.animesource.model.Video
import org.jsoup.nodes.Document

class Okoo : WebViewAnimeHttpSource() {
    override val name = "Okoo"
    override val lang = "fr"
    override val baseUrl = "https://www.okoo.fr"
    override val supportsLatest = false

    override fun popularAnimeRequest(page: Int) = Request(baseUrl)
    override fun popularAnimeParse(response: okhttp3.Response) = throw UnsupportedOperationException()

    override fun latestUpdatesRequest(page: Int) = Request(baseUrl)
    override fun latestUpdatesParse(response: okhttp3.Response) = throw UnsupportedOperationException()

    override fun animeDetailsParse(document: Document) = SAnime.create()
    override fun episodeListParse(document: Document) = emptyList<SEpisode>()
    override fun videoListParse(episode: SEpisode) = emptyList<Video>()

    override fun searchAnimeRequest(page: Int, query: String, filters: AnimeFilterList) =
        Request("$baseUrl/recherche/$query")

    override fun searchAnimeParse(response: okhttp3.Response) = throw UnsupportedOperationException()
}
