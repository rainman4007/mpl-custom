MPLPostStep('always') {
 print("Post step from Echo module "+ CFG)
}

print("CFG from Echo "+ CFG)
//def version = MPLModule('Test Echo', CFG).'artifact.version'
MPLModule('Test Echo', CFG)
//echo "${version}"
//OUT.'artifact_info.artifact.version' = version
//MPLPipelineConfigMerge(MPLModule('Test Echo', CFG).artifact_info)
print("global var from Echo "+ globalVars.name)