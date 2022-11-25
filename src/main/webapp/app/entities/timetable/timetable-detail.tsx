import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './timetable.reducer';

export const TimetableDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const timetableEntity = useAppSelector(state => state.timetable.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="timetableDetailsHeading">
          <Translate contentKey="educationApp.timetable.detail.title">Timetable</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.id}</dd>
          <dt>
            <span id="titleUz">
              <Translate contentKey="educationApp.timetable.titleUz">Title Uz</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.titleUz}</dd>
          <dt>
            <span id="titleRu">
              <Translate contentKey="educationApp.timetable.titleRu">Title Ru</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.titleRu}</dd>
          <dt>
            <span id="titleKr">
              <Translate contentKey="educationApp.timetable.titleKr">Title Kr</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.titleKr}</dd>
          <dt>
            <span id="contentUz">
              <Translate contentKey="educationApp.timetable.contentUz">Content Uz</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.contentUz}</dd>
          <dt>
            <span id="contentRu">
              <Translate contentKey="educationApp.timetable.contentRu">Content Ru</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.contentRu}</dd>
          <dt>
            <span id="contentKr">
              <Translate contentKey="educationApp.timetable.contentKr">Content Kr</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.contentKr}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="educationApp.timetable.status">Status</Translate>
            </span>
          </dt>
          <dd>{timetableEntity.status ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/timetable" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/timetable/${timetableEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default TimetableDetail;
