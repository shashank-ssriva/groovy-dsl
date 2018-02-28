import com.xebialabs.xlrelease.domain.Release
Release createdRelease = xlr {
  release('uname') {
    variables {
      stringVariable('output') {
        required false
        showOnReleaseStart false
      }
      stringVariable('err') {
        required false
        showOnReleaseStart false
      }
    }
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-08-14T13:00:00+0000')
    scriptUsername 'admin'
    scriptUserPassword 'password'
    phases {
      phase('New Phase') {
        tasks {
          custom('uname') {
            script {
              type 'remoteScript.Unix'
              script 'uname -a'
              output variable('output')
              err variable('err')
              address 'localhost'
              username 'admin'
              privateKeyFile '${global.rundeckkeyfile}'
            }
          }
        }
      }
    }
  }
}
releaseVariables["releaseID"] = createdRelease.id
print releaseVariables["releaseID"]
