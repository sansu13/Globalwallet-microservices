FROM python:3.10

WORKDIR /app

COPY . .

RUN pip install requests psycopg2-binary

CMD ["python", "exchange_worker.py"]