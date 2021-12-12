import argparse, os
import pandas as pd
import csv

def validate_file(f):
    if not os.path.exists(f):
        raise argparse.ArgumentTypeError(f"{f} does not exist.")
    return f

def validate_limit(file, limit):
    input_file = pd.read_csv(file)
    if input_file.shape[0] < limit:
        raise argparse.ArgumentTypeError("Number of rows you entered is higher than amount of rows in input file")

def split_csv(input_file, output_file, row_limit):
    cwd = os.getcwd()

    with open(input_file, 'r') as input_csv:
        data = csv.reader(input_csv)
        rows = list()

        for row in data:
            rows.append(row)

        header = rows.pop(0)

        c_chunk = 1
        for i in range(0, len(rows), row_limit):
            chunk = rows[i:i + row_limit-1]

            c_output = os.path.join(cwd,"{}-{}.csv".format(output_file,c_chunk))

            chunk.insert(0, header)

            with open(c_output, 'w') as output:
                writer = csv.writer(output)
                writer = writer.writerows(chunk)

            print()
            print("Chunk # {}:".format(c_chunk))
            print("Filepath: {}".format(c_output))
            print("# of rows: {}".format(len(chunk)))

            c_chunk += 1

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-i', '--input', dest='ifile', required=True, type=validate_file, help='input file', metavar='FILE')
    parser.add_argument('-o', '--output', dest='ofile', required=True, help='output file')
    parser.add_argument('-r', '--row-limit', dest='row_limit', required=True, help='row limit to split', type=int)


    args = parser.parse_args()
    validate_limit(args.ifile, args.row_limit)
    split_csv(args.ifile, args.ofile, args.row_limit)