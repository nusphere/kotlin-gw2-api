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
```