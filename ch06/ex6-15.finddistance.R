## 예제 6-15 R로 거리 구하기

#!/usr/bin/env Rscript
library("Imap")
f <- file("stdin")
open(f)
while(length(line <- readLines(f,n=1)) > 0) {
    # 각 라인 처리
    contents <- Map(as.numeric, strsplit(line, ","))
    mydist <- gdist(contents[[1]][1], contents[[1]][2],
                    contents[[1]][3], contents[[1]][4],
                    units="m", a=6378137.0, b=6356752.3142, verbose = FALSE)
    write(mydist, stdout())
}
