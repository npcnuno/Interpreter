load $1 to doc
setid = doc.id
courses = doc.course
elp = doc.course[0]
pacredits = doc.course[1].credits
elpeval = doc.course[0].evaluation
total = doc.course#
ids = doc.course->code
credits = doc.course->credits++

xml = ***
<summary count="$total" credits="$credits">
  <uc$courses name="$code"/>
</summary>
***

save xml to $2