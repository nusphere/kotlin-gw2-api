[![CI](https://github.com/nusphere/kotlin-gw2-api/actions/workflows/build_and_test.yml/badge.svg)](https://github.com/nusphere/kotlin-gw2-api/actions/workflows/build_and_test.yml)
[![codecov](https://codecov.io/gh/nusphere/kotlin-gw2-api/branch/master/graph/badge.svg?token=DWTS6NC7LP)](https://codecov.io/gh/nusphere/kotlin-gw2-api)
![master](https://badgen.net/badge/api/0.2.x-SNAPSHOT/orange?label=version)


##Use the library

The library provides an API class (guildwars2.Api). This class can be instantiated via API token and is made available via sub-classes (e.g. Misc). These subclasses reflect the same grouping as on the official wiki page of GW2 (https://wiki.guildwars2.com/wiki/API:Main)

```kotlin
import guildwars2.Api

fun main(args: Array<String>) {

    val gw2Api = Api("12345678-ZZZZ-YYYY-XXXX-ABCDEFGHIJKLMNOPQRST-CCCC-AAAA-BBBB-ABCDEFGHIJKL")

    println("${gw2Api.Misc().getBuild()}")
}
```

**We are currently working on making all API endpoints available. We therefore ask for your patience**


##Installation

please make sure that you have integrated the original maven repository

```build.gradle
repositories {
    mavenCentral()
}
```

To install the package, it can simply be added as a dependency.
```build.gradle
dependencies {
    implementation 'io.github.nusphere:kotlin-gw2-api:0.1.1'
}
```

###Additional developer information

```build.gradle
repositories {
    mavenCentral()

    // Developer Snapshot - last master deployment
    maven {
        url "https://s01.oss.sonatype.org/content/repositories/snapshots/"
        mavenContent {
            snapshotsOnly()
        }
    }
}

dependencies {
    implementation 'io.github.nusphere:kotlin-gw2-api:0.2.x-SNAPSHOT'
}
```

### Implementation Status

| Type                | Endpoint                     | Status      |
|---------------------|------------------------------|-------------|
| Achievements        | achievements                 | open        | 
| Achievements        | achievements/daily           | open        | 
| Achievements        | achievements/daily/tomorrow  | open        | 
| Achievements        | achievements/groups          | open        | 
| Achievements        | achievements/categories      | open        |
| Authenticated       | account                      | implemented |
| Authenticated       | account/achievements         | open        |
| Authenticated       | account/bank                 | open        |
| Authenticated       | account/dailycrafting        | open        |
| Authenticated       | account/dungeons             | open        |
| Authenticated       | account/dyes                 | implemented |
| Authenticated       | account/finishers            | implemented |
| Authenticated       | account/gliders              | open        |
| Authenticated       | account/home/cats            | open        |
| Authenticated       | account/home/nodes           | open        |
| Authenticated       | account/inventory            | open        |
| Authenticated       | account/luck                 | open        |
| Authenticated       | account/legendaryarmory      | open        |
| Authenticated       | account/mailcarriers         | open        |
| Authenticated       | account/mapchests            | open        |
| Authenticated       | account/masteries            | open        |
| Authenticated       | account/mastery/points       | open        |
| Authenticated       | account/materials            | open        |
| Authenticated       | account/minis                | open        |
| Authenticated       | account/mounts/skins         | open        |
| Authenticated       | account/mounts/types         | open        |
| Authenticated       | account/novelties            | open        |
| Authenticated       | account/outfits              | open        |
| Authenticated       | account/pvp/heroes           | open        |
| Authenticated       | account/raids                | open        |
| Authenticated       | account/recipes              | open        |
| Authenticated       | account/skins                | open        |
| Authenticated       | account/titles               | open        |
| Authenticated       | account/wallet               | open        |
| Authenticated       | account/worldbosses          | open        |
| Authenticated       | characters                   | open        |
| Authenticated       | commerce/transactions        | open        |
| Authenticated       | createsubtoken               | open        |
| Authenticated       | pvp/stats                    | open        |
| Authenticated       | pvp/games                    | open        |
| Authenticated       | pvp/standings                | open        |
| Authenticated       | tokeninfo                    | implemented |
| Daily Rewards       | dailycrafting                | open        | 
| Daily Rewards       | mapchests                    | open        |
| Daily Rewards       | worldbosses                  | open        | 
| Game Mechanics      | legendaryarmory              | open        |
| Game Mechanics      | masteries                    | open        |
| Game Mechanics      | mounts                       | open        |
| Game Mechanics      | mounts/skins                 | open        |
| Game Mechanics      | mounts/types                 | open        |
| Game Mechanics      | outfits                      | open        |
| Game Mechanics      | pets                         | open        |
| Game Mechanics      | professions                  | open        |
| Game Mechanics      | races                        | open        |
| Game Mechanics      | specializations              | open        |
| Game Mechanics      | skills                       | open        |
| Game Mechanics      | traits                       | open        |
| Game Mechanics      | legends                      | open        |
| Guild               | guild/:id                    | open        |
| Guild               | emblem                       | open        |
| Guild               | guild/permissions            | open        |
| Guild               | guild/search                 | open        |
| Guild               | guild/upgrades               | open        |
| Guild Authenticated | guild/:id/log                | open        |
| Guild Authenticated | guild/:id/members            | open        |
| Guild Authenticated | guild/:id/ranks              | open        |
| Guild Authenticated | guild/:id/stash              | open        |
| Guild Authenticated | guild/:id/storage            | open        |
| Guild Authenticated | guild/:id/treasury           | open        |
| Guild Authenticated | guild/:id/teams              | open        |
| Guild Authenticated | guild/:id/upgrades           | open        |
| Home Instance       | home/cats                    | open        |
| Home Instance       | home/nodes                   | open        |
| Items               | finishers                    | open        |
| Items               | items                        | open        |
| Items               | itemstats                    | open        |
| Items               | materials                    | open        |
| Items               | pvp/amulets                  | open        |
| Items               | recipes                      | open        |
| Items               | recipes/search               | open        |
| Items               | skins                        | open        |
| Map information     | continents                   | open        |
| Map information     | maps                         | open        |
| Miscellaneous       | build                        | implemented |
| Miscellaneous       | colors                       | implemented |
| Miscellaneous       | currencies                   | implemented |
| Miscellaneous       | dungeons                     | open        |
| Miscellaneous       | files                        | open        |
| Miscellaneous       | quaggans                     | implemented |
| Miscellaneous       | minis                        | open        |
| Miscellaneous       | novelties                    | open        |
| Miscellaneous       | raids                        | open        |
| Miscellaneous       | titles                       | implemented |
| Miscellaneous       | worlds                       | implemented |
| Story               | backstory/answers            | open        |
| Story               | backstory/questions          | open        |
| Story               | stories                      | open        |
| Story               | stories/seasons              | open        |
| Story               | quests                       | open        |
| Structured PvP      | pvp                          | open        |
| Structured PvP      | pvp/ranks                    | open        |
| Structured PvP      | pvp/seasons                  | open        |
| Structured PvP      | pvp/seasons/:id/leaderboards | open        |
| Trading post        | commerce/delivery            | open        |
| Trading post        | commerce/exchange            | open        |
| Trading post        | commerce/exchange/coins      | open        |
| Trading post        | commerce/exchange/gems       | open        |
| Trading post        | commerce/listings            | open        |
| Trading post        | commerce/prices              | open        |
| Trading post        | commerce/transactions        | open        |
| World vs. World     | wvw                          | implemented |
| World vs. World     | wvw/abilities                | implemented |
| World vs. World     | wvw/matches                  | implemented |
| World vs. World     | wvw/objectives               | implemented |
| World vs. World     | wvw/ranks                    | implemented |
| World vs. World     | wvw/upgrades                 | implemented |