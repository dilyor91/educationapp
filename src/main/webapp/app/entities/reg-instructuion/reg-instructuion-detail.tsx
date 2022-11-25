import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './reg-instructuion.reducer';

export const RegInstructuionDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const regInstructuionEntity = useAppSelector(state => state.regInstructuion.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="regInstructuionDetailsHeading">
          <Translate contentKey="educationApp.regInstructuion.detail.title">RegInstructuion</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.id}</dd>
          <dt>
            <span id="titleUz">
              <Translate contentKey="educationApp.regInstructuion.titleUz">Title Uz</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.titleUz}</dd>
          <dt>
            <span id="titleRu">
              <Translate contentKey="educationApp.regInstructuion.titleRu">Title Ru</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.titleRu}</dd>
          <dt>
            <span id="titleKr">
              <Translate contentKey="educationApp.regInstructuion.titleKr">Title Kr</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.titleKr}</dd>
          <dt>
            <span id="contentUz">
              <Translate contentKey="educationApp.regInstructuion.contentUz">Content Uz</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.contentUz}</dd>
          <dt>
            <span id="contentRu">
              <Translate contentKey="educationApp.regInstructuion.contentRu">Content Ru</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.contentRu}</dd>
          <dt>
            <span id="contentKr">
              <Translate contentKey="educationApp.regInstructuion.contentKr">Content Kr</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.contentKr}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="educationApp.regInstructuion.status">Status</Translate>
            </span>
          </dt>
          <dd>{regInstructuionEntity.status ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/reg-instructuion" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/reg-instructuion/${regInstructuionEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default RegInstructuionDetail;
