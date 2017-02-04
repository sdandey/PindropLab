import csv
from urllib.request import urlopen
from bs4 import BeautifulSoup

html = open("Forum.htm")
beautifulSoup = BeautifulSoup(html)

#
# <li class="oos_listItem">
#  <ul class="oos_preview oos_preview40">
#   <li class="oos_previewSide">
#    <img alt="avatar" class="oos_avatar" src="./Forum_files/anon.png"/>
#   </li>
#   <li class="oos_previewHeader">
#    <a class="oos_previewTitle" href="http://800notes.com/forum/ta-6e2a840d986d2b6/a-caller-id-191-7885-7864">
#     A caller ID +191 7885-7864
#    </a>
#   </li>
#   <li class="oos_previewFooter">
#    Posts: 83 | Last post:
#    <time datetime="2017-01-29T09:05:32Z">
#     29 Jan 2017
#    </time>
#    by Mcbhench | Forum: Everything else
#   </li>
#   <li class="oos_previewBody">
#    Same for me few minutes ago I receive a call using thus codes saying they are new zealand immigration and asking my credit card no. For assessment fee. I surprise why they ask money immediately. I come to know now that no. Is scam. Thanks God for not being a victim again.
#    <input name="thread_ts" type="hidden" value="6e2a840d986d2b6=81e20"/>
#   </li>
#  </ul>
# </li>
#

forum_topics = []
for each_topic in beautifulSoup.findAll("li", {"class": "oos_listItem"}):
    #print(list_of_all_items.prettify())
    forum_attributes = []
    for header in each_topic.findAll("li", {"class": "oos_previewHeader"}):
        forum_attributes.append(header.get_text())
        forum_attributes.append(header.find('a')['href'])
    for footer in each_topic.findAll("li", {"class": "oos_previewFooter"}):
        print(footer.find("time"))
        for element in footer.get_text().split("|"):
            forum_attributes.append(element.split(":")[1])


    forum_topics.append(forum_attributes)


outfile = open("./1800_notes.csv", "w")
writer = csv.writer(outfile)
writer.writerow(["Topic Name", "Topic Link","Number of Comments", "Latest Comment Date", "Category"])
writer.writerows(forum_topics)

for row in forum_topics:
    print(row)

for eachrow in forum_topics:
    print(eachrow)

