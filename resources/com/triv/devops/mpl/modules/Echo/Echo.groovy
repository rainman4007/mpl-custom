def version = MPLModule('Test Echo', CFG).'artifact.version'
echo "${version}"
OUT.'artifact_info.artifact.version' = version
//MPLPipelineConfigMerge(MPLModule('Test Echo', CFG).artifact_info)
echo "${CFG}"