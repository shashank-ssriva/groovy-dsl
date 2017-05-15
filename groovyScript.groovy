createdRelease = xlr {
    release("Hello world release") {
        description "Hello world release description"
        phases {
            phase {
                title "Sample"
                tasks {
                    manual("Manual task") {
                        description "Manual task description"
                    }
                }
            }
        }
    }
}

println '\n'
println 'Created release with ID: ' + createdRelease.id

println '\n'
println 'Aborting release.'
myRelease = releaseApi.abort(createdRelease.id)
