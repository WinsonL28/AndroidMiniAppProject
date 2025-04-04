package com.bcit.myminiapp.data

import com.google.gson.annotations.SerializedName


// Root Wrapper Class
data class StudyResponse(
    @SerializedName("studies")
    val studies: List<Study> // List because "studies" is an array
)

// Study Data Class (Wraps "protocolSection")
data class Study(
    @SerializedName("protocolSection")
    val protocolSection: ProtocolSection
)

// Actual Protocol Section that Contains Other Modules
data class ProtocolSection(
    @SerializedName("identificationModule")
    val identificationModule: IdentificationModule?,
//    @SerializedName("statusModule")
//    val statusModule: StatusModule?,
//    @SerializedName("sponsorCollaboratorsModule")
//    val sponsorCollaboratorsModule: SponsorCollaboratorsModule?,
    @SerializedName("descriptionModule")
    val descriptionModule: DescriptionModule?
)


// Identification Module
data class IdentificationModule(
    @SerializedName("nctId")
    val id: String,
//    @SerializedName("orgStudyIdInfo")
//    val orgStudyIdInfo: OrgStudyIdInfo,
//    @SerializedName("organization")
//    val organization: Organization,
    @SerializedName("briefTitle")
    val briefTitle: String,
    @SerializedName("officialTitle")
    val officialTitle: String
)
//
//data class OrgStudyIdInfo(@SerializedName("id") val id: String)
//
//data class Organization(
//    @SerializedName("fullName") val fullName: String,
//    @SerializedName("class") val classType: String
//)
//
//// Status Module
//data class StatusModule(
//    @SerializedName("overallStatus") val overallStatus: String,
//    @SerializedName("startDateStruct") val startDateStruct: DateStruct,
//    @SerializedName("completionDateStruct") val completionDateStruct: DateStruct,
//)
//
//data class ExpandedAccessInfo(@SerializedName("hasExpandedAccess") val hasExpandedAccess: Boolean)
//
//data class DateStruct(
//    @SerializedName("date") val date: String,
//    @SerializedName("type") val type: String
//)
//
//// Sponsor and Collaborators Module
//data class SponsorCollaboratorsModule(
//    @SerializedName("leadSponsor") val leadSponsor: Sponsor,
//    @SerializedName("collaborators") val collaborators: List<Sponsor>
//)
//
//data class Sponsor(
//    @SerializedName("name") val name: String,
//    @SerializedName("class") val classType: String
//)
//
//
// Description Module
data class DescriptionModule(
    @SerializedName("briefSummary") val briefSummary: String,
    @SerializedName("detailedDescription") val detailedDescription: String
)

